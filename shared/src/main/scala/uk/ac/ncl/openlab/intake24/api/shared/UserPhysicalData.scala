package uk.ac.ncl.openlab.intake24.api.data

import java.time.LocalDate

case class UserPhysicalData(userId: Long, sex: Option[String],
                            birthdate: Option[LocalDate],
                            weight: Option[Double], weightTarget: Option[String],
                            height: Option[Double], physicalActivityLevelId: Option[Long])

case class UserPhysicalDataUpdate(sex: Option[String],
                                  birthdate: Option[LocalDate],
                                  weight: Option[Double], weightTarget: Option[String],
                                  height: Option[Double], physicalActivityLevelId: Option[Long])
