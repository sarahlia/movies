**MoovyMagic**

**A simple movie bookmarking application that gets movie data from OMDB API, built with Java and Spring Boot**

*	Java + Spring Boot
*	Hibernate ORM + JPA
*	MySQL
*	Bootstrap CSS Framework
* Thymeleaf
*	JavaScript/jQuery
*	Spring Integration Tests

**Features List**
*	Search: Visitors can search for movies using a keyword. Movies containing the keyword will appear in the results. 
* Movie details: Upon clicking on a specific movie, visitors are able to see that movie's details.
*	Bookmark: Visitors have the ability to create a bookmark, view all the bookmarks in the dashboard, and delete a bookmark. Bookmarks persist across multiple browsers and sessions.

**Made with Java 11, Spring Boot v 2.3.4, IntelliJ IDE, and Maven.**
**Instructions to run project:** 
1. Github:
      a. Clone repository.
      b. Copy SSH key.
2. IntelliJ IDE: Get from Version Control, paste SSH key, Clone. 
3. Rebuild pom.xml if needed.
4. In src/main/resources, create application.properties file.
      a. Copy everything from example.properties file in the same folder.
      b. Change password to $ometh1ng
5. Ensure MySQL is running.
      a. Run all the queries in the setup.sql file in src/main/sql.
      b. Replace asterisks with the password above.
6. Run MoviesApplication 
7. Web browser:
      a. Go to: **localhost/dashboard**
      b. Start by searching a movie, then select a movie, add a bookmark, and delete a bookmark.
8. (Optional: run BookmarksIntegrationTests).
# cloned-movies
