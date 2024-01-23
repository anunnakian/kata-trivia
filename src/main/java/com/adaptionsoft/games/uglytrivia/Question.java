package com.adaptionsoft.games.uglytrivia;

class Question {

  private final String message;

  Question(Category category, int index) {
    message = category.getCategory() + " Question " + index;
  }

  String getMessage() {
    return message;
  }
}
