import reactor.core.publisher.Flux;
import java.time.Duration;
import java.util.Random;

public class MonitoreoICU {

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();

        Flux<EventoVital> paciente1 = generarSignosVitales(1, random);
        Flux<EventoVital> paciente2 = generarSignosVitales(2, random);
        Flux<EventoVital> paciente3 = generarSignosVitales(3, random);

        Flux.merge(paciente1, paciente2, paciente3)
                .filter(EventoVital::esCritico)
                .sort((e1, e2) -> e1.prioridad() - e2.prioridad())
                .subscribe(MonitoreoICY::imprimirAlertaCritica);

        Thread.sleep(5000);
    }

    private static void imprimirAlertaCritica(EventoVital evento) {
        if (evento.tieneFcCritica()) {
            System.out.println("⚠️ Paciente " + evento.pacienteId + " - FC crítica: " + evento.fc + " bpm");
        } else if (evento.tieneSpo2Bajo()) {
            System.out.println("⚠️ Paciente " + evento.pacienteId + " - SpO2 baja: " + evento.spo2 + "%");
        } else if (evento.tienePaCritica()) {
            System.out.println("⚠️ Paciente " + evento.pacienteId + " - PA crítica: " + evento.pas + "/" + evento.pad + " mmHg");
        }
    }

    private static Flux<EventoVital> generarSignosVitales(int pacienteId, Random random) {
        return Flux.interval(Duration.ofMillis(300))
                .map(tick -> {
                    int fc = 40 + random.nextInt(100);  // 40-139
                    int pas = 80 + random.nextInt(80);  // 80-159
                    int pad = 50 + random.nextInt(50);  // 50-99
                    int spo2 = 80 + random.nextInt(20); // 80-99 (antes 85-99)

                    return new EventoVital(pacienteId, fc, pas, pad, spo2);
                })
                .take(20);
    }

    static class EventoVital {
        private final int pacienteId;
        final int fc;
        final int pas;
        final int pad;
        final int spo2;

        public EventoVital(int pacienteId, int fc, int pas, int pad, int spo2) {
            this.pacienteId = pacienteId;
            this.fc = fc;
            this.pas = pas;
            this.pad = pad;
            this.spo2 = spo2;
        }

        public boolean esCritico() {
            return tieneFcCritica() || tieneSpo2Bajo() || tienePaCritica();
        }

        public boolean tieneFcCritica() {
            return fc < 50 || fc > 120;
        }

        public boolean tieneSpo2Bajo() {
            return spo2 < 90;
        }

        public boolean tienePaCritica() {
            return pas < 90 || pas > 140 || pad < 60 || pad > 90;
        }

        public int prioridad() {
            if (tieneFcCritica()) return 1;
            if (tieneSpo2Bajo()) return 2;
            if (tienePaCritica()) return 3;
            return 4;
        }
    }
}