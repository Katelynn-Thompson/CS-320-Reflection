import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppointmentService {
    private List<Appointment> appointments;

    public AppointmentService() {
        appointments = new ArrayList<>();
    }

    public void addAppointment(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment must not be null");
        }

        if (appointmentExists(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("Appointment ID must be unique");
        }

        appointments.add(appointment);
    }

    public void deleteAppointment(String appointmentId) {
        if (appointmentId == null) {
            throw new IllegalArgumentException("Appointment ID must not be null");
        }

        Iterator<Appointment> iterator = appointments.iterator();
        while (iterator.hasNext()) {
            Appointment appointment = iterator.next();
            if (appointment.getAppointmentId().equals(appointmentId)) {
                iterator.remove(); // Use iterator to safely remove the element
                return;
            }
        }

        throw new IllegalArgumentException("Appointment not found");
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public Appointment getAppointment(String appointmentId) {
        if (appointmentId == null) {
            throw new IllegalArgumentException("Appointment ID must not be null");
        }

        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentId().equals(appointmentId)) {
                return appointment;
            }
        }

        return null; // Appointment not found
    }

    private boolean appointmentExists(String appointmentId) {
        for (Appointment existingAppointment : appointments) {
            if (existingAppointment.getAppointmentId().equals(appointmentId)) {
                return true;
            }
        }
        return false;
    }
}

