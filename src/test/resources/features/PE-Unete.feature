@peru
Feature: Register successfully a postulant in Country Perú

  @postulante-peru
  Scenario: Register a Postulant with credit
    Given a Postulant of peru register in web
    When the peru Postulant have credit
    Then register for peru is successfully