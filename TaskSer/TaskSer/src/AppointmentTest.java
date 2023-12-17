import org.junit.Test;
import java.util.Date;
import static org.junit.Assert.*;

public class AppointmentTest {

    // Tests the creation of a valid appointment
    @Test
    public void testCreateAppointment() {
        Appointment appointment = new Appointment("A00001", new Date(), "Appointment Description");
        assertNotNull(appointment);
    }

    // Tests that the appointment ID is correctly set
    @Test
    public void testAppointmentID() {
        Appointment appointment = new Appointment("A00001", new Date(), "Appointment Description");
        assertEquals("A00001", appointment.getAppointmentId());
    }

 // Tests that the appointment date is correctly set
    @Test
    public void testAppointmentDate() {
        Date appointmentDate = new Date();
        Appointment appointment = new Appointment("A00001", appointmentDate, "Appointment Description");
        assertEquals(appointmentDate.getTime(), appointment.getAppointmentDate().getTime());
    }


    // Tests that creating an appointment with a date in the past throws an exception
    @Test(expected = IllegalArgumentException.class)
    public void testAppointmentDateInThePast() {
        Date appointmentDate = new Date(System.currentTimeMillis() - 1000 * 60 * 60 * 24);
        Appointment appointment = new Appointment("A00001", appointmentDate, "Appointment Description");
    }

    // Tests that the description is correctly set
    @Test
    public void testAppointmentDescription() {
        Appointment appointment = new Appointment("A00001", new Date(), "Appointment Description");
        assertEquals("Appointment Description", appointment.getDescription());
    }

    // Tests that creating an appointment with an ID that is too long throws an exception
    @Test(expected = IllegalArgumentException.class)
    public void testAppointmentIDTooLong() {
        Appointment appointment = new Appointment("A0000000001", new Date(), "Appointment Description");
    }

    // Tests that creating an appointment with a null ID throws an exception
    @Test(expected = IllegalArgumentException.class)
    public void testAppointmentIDNull() {
        Appointment appointment = new Appointment(null, new Date(), "Appointment Description");
    }

    // Tests that creating an appointment with a null date throws an exception
    @Test(expected = IllegalArgumentException.class)
    public void testAppointmentDateNull() {
        Appointment appointment = new Appointment("A00001", null, "Appointment Description");
    }

    // Tests that creating an appointment with a null description throws an exception
    @Test(expected = IllegalArgumentException.class)
    public void testAppointmentDescriptionNull() {
        Appointment appointment = new Appointment("A00001", new Date(), null);
    }

    // Tests that creating an appointment with a too long description throws an exception
    @Test(expected = IllegalArgumentException.class)
    public void testAppointmentDescriptionTooLong() {
        String description = "Appointment Description that is too long and should throw an IllegalArgumentException";
        Appointment appointment = new Appointment("A00001", new Date(), description);
    }
}
