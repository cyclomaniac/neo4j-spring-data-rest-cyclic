# neo4j-spring-data-rest-cyclic

Demonstrate issue with rendering of cyclic data using a small test case.

Whenever a RelationshipEntity is created, a cyclic behavior occurs during serialization.

Using JSOG short circuits the behavior, but does not result in a correctly rendered response.

Using JsonManagedReference/JsonBackReference may work, but the goal is to be able to navigate the relationship from
either the Team or the Player repositories.
