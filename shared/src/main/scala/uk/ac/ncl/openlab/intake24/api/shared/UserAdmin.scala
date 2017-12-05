package uk.ac.ncl.openlab.intake24.api.shared

import java.time.LocalDate

case class NewUserProfile(name: Option[String], email: Option[String], phone: Option[String], roles: Set[String], customFields: Map[String, String])

case class UserProfile(name: Option[String], email: Option[String], phone: Option[String], emailNotifications: Boolean, smsNotifications: Boolean)

case class CreateUserRequest(userInfo: NewUserProfile, password: String)

case class UserProfileWithPhysicalData(userProfile: UserProfile,
                                       physicalData: Option[UserPhysicalDataUpdate])


case class DeleteUsersRequest(userIds: Seq[Long])

case class DeleteSurveyUsersRequest(userNames: Seq[String])



case class PatchUserPasswordRequest(password: String)

case class NewRespondent(userName: String, password: String, name: Option[String], email: Option[String], phone: Option[String], customFields: Map[String, String])

case class CreateOrUpdateSurveyUsersRequest(users: Seq[NewRespondent])

case class UserInfoWithSurveyUserName(id: Long, userName: String, name: Option[String], email: Option[String], phone: Option[String], emailNotifications: Boolean, smsNotifications: Boolean, roles: Set[String], customFields: Map[String, String])

case class CreateRespondentsWithPhysicalDataRequest(users: Seq[NewRespondentWithPhysicalData])

case class CreateRespondentsWithPhysicalDataResponse(userKeys: Seq[NewRespondentIds])

case class PasswordResetRequest(email: String, recaptchaResponse: String)

case class PasswordResetConfirmation(token: String, newPassword: String)

case class NewRespondentWithPhysicalData(externalId: String, name: Option[String], email: Option[String],
                                         phone: Option[String], sex: Option[String], birthdate: Option[LocalDate],
                                         weight: Option[Double], weightTarget: Option[String], height: Option[Double])

case class NewRespondentIds(userId: Long, externalId: String, urlAuthToken: String)

