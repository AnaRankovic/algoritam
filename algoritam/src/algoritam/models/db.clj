(ns algoritam.models.db
     (:require [clojure.java.jdbc :as sql])
    (:import java.sql.DriverManager))

(def db
  "Definition of database"
  {:classname "org.sqlite.JDBC",
         :subprotocol "sqlite",
         :subname "film_critics.sqlite"})

(defn create-table []
    "Creates table"
  (sql/with-connection
    db
    (sql/create-table
      :film_critics
      [:Id "INTEGER PRIMARY KEY AUTOINCREMENT"]
      [:Name "TEXT"]
      [:Lady_in_the_Water "REAL"]
      [:Snakes_on_a_Plane "REAL"]
      [:Just_My_Luck "REAL"]
      [:Superman_Returns "REAL"]
      [:You_Me_and_Dupree "REAL"]
      [:The_Night_Listener"REAL"]
      )))