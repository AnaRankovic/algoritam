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
      [:The_Night_Listener "REAL"])))

(defn vrati-Lady_in_the_Water [Name]
  "Select user with given name"
  (sql/with-connection
  db
   (get (sql/with-query-results res
    ["select Lady_in_the_Water from film_critics where Name = ?" Name] (first res)) :lady_in_the_water)))

(defn vrati-Snakes_on_a_Plane [Name]
  "Select user with given name"
  (sql/with-connection
  db
   (get (sql/with-query-results res
    ["select Snakes_on_a_Plane from film_critics where Name = ?" Name] (first res)) :snakes_on_a_plane)))

(defn vrati-Just_My_Luck [Name]
  "Select user with given name"
  (sql/with-connection
  db
  (get (sql/with-query-results res
    ["select Just_My_Luck from film_critics where Name = ?" Name] (first res)) :just_my_luck)))

(defn vrati-Superman_Returns [Name]
  "Select user with given name"
  (sql/with-connection
  db
   (get (sql/with-query-results res
    ["select Superman_Returns from film_critics where Name = ?" Name] (first res)) :superman_returns )))

(defn vrati-You_Me_and_Dupree [Name]
  "Select user with given name"
  (sql/with-connection
  db
   (get (sql/with-query-results res
    ["select You_Me_and_Dupree from film_critics where Name = ?" Name] (first res)) :you_me_and_dupree)))

(defn vrati-The_Night_Listener [Name]
  "Select user with given name"
  (sql/with-connection
  db
   (get (sql/with-query-results res
    ["select The_Night_Listener from film_critics where Name = ?" Name] (first res)) :the_night_listener)))

(defn vrati_ime_kolone [Name]
  "Select user with given name"
  (sql/with-connection
  db
   (get (sql/with-query-results res
    ["select column_name from film_critics where Name = ?" Name] (first res)) :the_night_listener)))