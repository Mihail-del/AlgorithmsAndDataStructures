package ua.univercity;

sealed interface Result permits Success, Failure {}

record Success(String data) implements Result {}
record Failure(String message) implements Result {}
