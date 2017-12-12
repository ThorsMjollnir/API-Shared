package uk.ac.ncl.openlab.intake24.api.data.admin

import java.util.UUID

import uk.ac.ncl.openlab.intake24.api.data._

case class CategoryHeader(code: String, englishDescription: String, localDescription: Option[String], isHidden: Boolean)

case class NewCategory(code: String, englishDescription: String, isHidden: Boolean, attributes: InheritableAttributes) {
  def toHeader = CategoryHeader(code, englishDescription, None, isHidden)
}

case class CategoryRecord(main: MainCategoryRecord, local: LocalCategoryRecord)

case class NewMainCategoryRecord(code: String, englishDescription: String, isHidden: Boolean, attributes: InheritableAttributes, parentCategories: Seq[String]) {
  def toNewCategory = NewCategory(code, englishDescription, isHidden, attributes)
}

case class MainCategoryRecord(version: UUID, code: String, englishDescription: String, isHidden: Boolean, attributes: InheritableAttributes,
                              parentCategories: Seq[CategoryHeader]) {
  def toUpdate = MainCategoryRecordUpdate(version, code, englishDescription, isHidden, attributes, parentCategories.map(_.code))
}

case class MainCategoryRecordUpdate(baseVersion: UUID, code: String, englishDescription: String, isHidden: Boolean, attributes: InheritableAttributes,
                                    parentCategories: Seq[String])


case class LocalCategoryRecord(version: Option[UUID], localDescription: Option[String], portionSize: Seq[PortionSizeMethod]) {
  def toUpdate = LocalCategoryRecordUpdate(version, localDescription, portionSize)
}

case class NewLocalCategory(localDescription: Option[String])

case class NewLocalCategoryRecord(localDescription: Option[String], portionSize: Seq[PortionSizeMethod])

case class LocalCategoryRecordUpdate(baseVersion: Option[UUID], localDescription: Option[String], portionSize: Seq[PortionSizeMethod])

case class CategoryContents(foods: Seq[FoodHeader], subcategories: Seq[CategoryHeader])

case class CategoryV2(version: UUID, code: String, description: String, foods: Seq[String], subcategories: Seq[String], isHidden: Boolean, attributes: InheritableAttributes, portionSizeMethods: Seq[PortionSizeMethod])