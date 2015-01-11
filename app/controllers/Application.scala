package controllers

import data.MealDao
import models.Meal
import play.api.mvc._
import org.json4s._
import org.json4s.jackson.JsonMethods._
import com.github.tototoshi.play2.json4s.jackson._

object Application extends Controller with Json4s {

  implicit val formats = DefaultFormats

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def allMeals = Action {implicit request =>
    val meals: List[Meal] = MealDao.all
    Ok(Extraction.decompose(meals))
  }
}