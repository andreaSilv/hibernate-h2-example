# hibernate-h2-example
In this readme
* Overview
* How to import
* Change configurations

### Overview
Basical example of hibernate usage. I developed this tiny project just to understrand how hibernate works.
I don't know if this is good approach. __All suggestions are welcome__

File tree:
* src/main/java:
  * bean: (__User.java__) you can imagine
  * dao: (__UserDAO.java__) you can imagine too
  * app: (__App.java__) contains only __main__ method for run (App.java)
* config:
  * (__hibernate.cfg.xml__) hibernate config file
  * (__initialize.sql__) sql script for db initialization
* res:
  * (__h2.db.mv.db__) will be contain db

### How to import
This is a __maven__ project developed in __Eclipse IDE__, so just clone it and import as __Maven project__

### Change configurations
I don't lost enought time to parametrize the config values. 
* You can found db configuration in __config__ folder
* Which db will be used is written in __UserDAO.java__ constructor
