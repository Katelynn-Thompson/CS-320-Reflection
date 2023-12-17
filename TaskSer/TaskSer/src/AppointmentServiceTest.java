import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class AppointmentServiceTest {
    
    private AppointmentService appointmentService;
    
    @Before
    public void setUp() {
        appointmentService = new AppointmentService();
    }
    
    @Test
    public void testAddAppointment() {
        Appointment appointment = new Appointment("A123456789", new Date(), "Test Appointment");
        appointmentService.addAppointment(appointment);
        // No assert statement; check console output for any errors
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateAppointment() {
        Appointment appointment1 = new Appointment("A123456789", new Date(), "Test Appointment 1");
        Appointment appointment2 = new Appointment("A123456789", new Date(), "Test Appointment 2");
        appointmentService.addAppointment(appointment1);
        appointmentService.addAppointment(appointment2);
        // Expecting IllegalArgumentException, so no assert statement is needed
    }
    
    @Test
    public void testDeleteAppointment() {
        Appointment appointment = new Appointment("A123456789", new Date(), "Test Appointment");
        appointmentService.addAppointment(appointment);
        appointmentService.deleteAppointment("A123456789");
        // No assert statement; check console output for any errors
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testDeleteNonExistentAppointment() {
        appointmentService.deleteAppointment("B123456789");
        // Expecting IllegalArgumentException, so no assert statement is needed
    }
    
    @Test
    public void testGetAppointment() {
        Appointment appointment = new Appointment("A123456789", new Date(), "Test Appointment");
        appointmentService.addAppointment(appointment);
        appointmentService.getAppointment("A123456789");
        // No assert statement; check console output for any errors
    }
    
    @Test
    public void testGetNonExistentAppointment() {
        appointmentService.getAppointment("B123456789");
        // No assert statement; check console output for any errors
    }
    
    @Test
    public void testGetAppointments() {
        Appointment appointment1 = new Appointment("A123456789", new Date(), "Test Appointment 1");
        Appointment appointment2 = new Appointment("B123456789", new Date(), "Test Appointment 2");
        appointmentService.addAppointment(appointment1);
        appointmentService.addAppointment(appointment2);
        appointmentService.getAppointments();
        // No assert statement; check console output for any errors
    }
}
