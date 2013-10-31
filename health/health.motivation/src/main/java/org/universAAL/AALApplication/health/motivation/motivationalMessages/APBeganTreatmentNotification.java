/*******************************************************************************
 * Copyright 2013 Universidad Polit�cnica de Madrid
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.universAAL.AALApplication.health.motivation.motivationalMessages;

import org.universAAL.ontology.ICD10CirculatorySystemDiseases.owl.HeartFailure;
import org.universAAL.ontology.health.owl.MotivationalStatusType;
import org.universAAL.ontology.health.owl.Treatment;
import org.universAAL.ontology.owl.MotivationalMessage;
import org.universAAL.ontology.owl.MotivationalMessageClassification;
import org.universAAL.ontology.owl.MotivationalMessageSubclassification;
import org.universAAL.ontology.owl.MotivationalPlainMessage;

public class APBeganTreatmentNotification implements MotivationalMessageContent{

	String content = "Good $partOfDay $caregiverName! $userName has begun $userPosesiveGender treatment: $treatmentName." + 
	" The platform will notify you with new updates, whenever they happen. Regards.";

	String name = "Meessage sent to caregiver when user performs the first session of her/his treatment";
	MotivationalPlainMessage treatmentFirstSessionPerformanceNotificationToCaregiver = new MotivationalPlainMessage (name, HeartFailure.MY_URI, Treatment.MY_URI, MotivationalStatusType.contemplation, MotivationalMessageClassification.notification, MotivationalMessageSubclassification.treatment_performance_agreement, content);

	public Object getMessageContent() {
		return treatmentFirstSessionPerformanceNotificationToCaregiver.getContent();
	}

	public MotivationalMessage getMotivationalMessage() {
		return treatmentFirstSessionPerformanceNotificationToCaregiver;
	}

}
