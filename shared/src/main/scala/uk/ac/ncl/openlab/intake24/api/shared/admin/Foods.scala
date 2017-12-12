package uk.ac.ncl.openlab.intake24.api.data.admin

import java.util.UUID

import uk.ac.ncl.openlab.intake24.api.data._

case class FoodHeader(code: String, englishDescription: String, localDescription: Option[String], excluded: Boolean)

case class AssociatedFoodWithHeader(foodOrCategoryHeader: Either[FoodHeader, CategoryHeader], promptText: String, linkAsMain: Boolean, genericName: String) {
  def toAssociatedFood = {
    val foodOrCategoryCode = foodOrCategoryHeader.left.map(_.code).right.map(_.code)
    AssociatedFood(foodOrCategoryCode, promptText, linkAsMain, genericName)
  }
}

case class MainFoodRecord(version: UUID, code: String, englishDescription: String, groupCode: Int, attributes: InheritableAttributes,
                          parentCategories: Seq[CategoryHeader], localeRestrictions: Seq[String])

case class MainFoodRecordUpdate(baseVersion: UUID, code: String, englishDescription: String, groupCode: Int, attributes: InheritableAttributes,
                                parentCategories: Seq[String], localeRestrictions: Seq[String])


case class FoodRecord(main: MainFoodRecord, local: LocalFoodRecord) {
  def allowedInLocale(locale: String) = (main.localeRestrictions.isEmpty || main.localeRestrictions.contains(locale)) && !local.doNotUse
}

case class LocalFoodRecord(version: Option[UUID], localDescription: Option[String], doNotUse: Boolean,
                           nutrientTableCodes: Map[String, String], portionSize: Seq[PortionSizeMethod], associatedFoods: Seq[AssociatedFoodWithHeader],
                           brandNames: Seq[String]) {
  def toUpdate = LocalFoodRecordUpdate(version, localDescription, doNotUse, nutrientTableCodes, portionSize, associatedFoods.map(_.toAssociatedFood), brandNames)
}

case class NewMainFoodRecord(code: String, englishDescription: String, groupCode: Int, attributes: InheritableAttributes, parentCategories: Seq[String], localeRestrictions: Seq[String]) {
  def toHeader = FoodHeader(code, englishDescription, None, false)
}

case class NewLocalMainFoodRecord(code: String, englishDescription: String, groupCode: Int, attributes: InheritableAttributes, parentCategories: Seq[String])

case class NewFoodAutoCode(englishDescription: String, groupCode: Int, attributes: InheritableAttributes)

case class LocalFoodRecordUpdate(baseVersion: Option[UUID], localDescription: Option[String], doNotUse: Boolean,
                                 nutrientTableCodes: Map[String, String], portionSize: Seq[PortionSizeMethod], associatedFoods: Seq[AssociatedFood],
                                 brandNames: Seq[String])

case class NewLocalFoodRecord(localDescription: Option[String], doNotUse: Boolean,
                              nutrientTableCodes: Map[String, String], portionSize: Seq[PortionSizeMethod], associatedFoods: Seq[AssociatedFood],
                              brandNames: Seq[String])

