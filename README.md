# This repository maintains the code for my path on learning Spring, Hibernate and Maven
To learn these technologies, I'm implementing a dummy Online Clinic System
There are 3 actors in the implementation: Admin, Patient and Doctor

# Roles of the Doctor
1) To add or remove a user (user can be a new dcotor, patient or a admin)
2) To confirm schedule appointment
  2.1) The admin gets a list of all the doctors with their specialization
  2.2) The admin gets a list of all the patients with their ailment details and the patient's preferred date
  2.3) Based on these criteria the doctor schedules the appointment
  
# Roles of the Patient
1) Can submit request for appointment by giving the ailment details
2) Can view the appointment details

# Roles of the Admin
1) Can see the ailment details of the patients and the specialization of the doctors
2) Assigns doctor to patient by matching the specialization and ailment
3) Schedules the appointment
