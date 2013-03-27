package org.universAAL.AALapplication.medication_manager.servlet.ui.impl.servlets.helpers;

import org.universAAL.AALapplication.medication_manager.persistence.layer.entities.Person;
import org.universAAL.AALapplication.medication_manager.servlet.ui.impl.MedicationManagerServletUIException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.universAAL.AALapplication.medication_manager.servlet.ui.impl.Util.*;

/**
 * @author George Fournadjiev
 */
public final class NewPrescriptionView {

  private final int prescriptionId;
  private String description;
  private String startDate;
  private Map<Integer, MedicineView> medicineViews = new HashMap<Integer, MedicineView>();
  private Person physician;
  private Person patient;

  public NewPrescriptionView(int prescriptionId, Person physician, Person patient) {
    this.prescriptionId = prescriptionId;
    this.physician = physician;
    this.patient = patient;
  }

  public int getPrescriptionId() {
    return prescriptionId;
  }

  public String getNotes() {
    return description;
  }

  public void setNotes(String description) {
    this.description = description;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    validateDate(startDate);

    this.startDate = startDate;
  }

  public Person getPhysician() {
    return physician;
  }

  public Person getPatient() {
    return patient;
  }

  public Set<MedicineView> getMedicineViewSet() {
    return new HashSet<MedicineView>(medicineViews.values());
  }

  public void addMedicineView(MedicineView medicineView) {
    medicineViews.put(medicineView.getMedicineId(), medicineView);
  }

  public void removeMedicineView(int medicineViewId) {
    MedicineView medicineView = medicineViews.remove(medicineViewId);
    if (medicineView == null) {
      throw new MedicationManagerServletUIException("Missing medicineView with id: " + medicineViewId);
    }
  }

}
