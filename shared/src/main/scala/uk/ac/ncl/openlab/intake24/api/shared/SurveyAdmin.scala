package uk.ac.ncl.openlab.intake24.api.data

import java.time.ZonedDateTime

case class CreateSurveyRequest(id: String, startDate: ZonedDateTime, endDate: ZonedDateTime, schemeId: String,
                               localeId: String, allowGeneratedUsers: Boolean, externalFollowUpURL: Option[String],
                               supportEmail: String)
