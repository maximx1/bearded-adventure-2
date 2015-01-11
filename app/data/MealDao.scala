package data

import models.Meal
import anorm._
import anorm.SqlParser._
import play.api.db._
import play.api.Play.current

/**
 * Created by maxim_000 on 1/11/2015.
 */
object MealDao {
  val meal = {
    get[Long]("MEAL_ID") ~
    get[String]("MEAL_NAME") ~
    get[BigDecimal]("MEAL_PRICE") ~
    get[Long]("MEAL_OPTGROUP_ID") map {
      case mealId ~ mealName ~ mealPrice ~ mealOptgroupId => Meal(mealId, mealName, mealPrice.toFloat, mealOptgroupId)
    }
  }

  def all: List[Meal] = DB.withConnection { implicit x =>
    SQL("select * from MEALS").as(meal *)
  }
}
