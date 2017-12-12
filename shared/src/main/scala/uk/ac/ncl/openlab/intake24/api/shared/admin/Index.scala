package uk.ac.ncl.openlab.intake24.api.shared.admin

case class SplitList(splitWords: Seq[String], keepPairs: Map[String, Set[String]])