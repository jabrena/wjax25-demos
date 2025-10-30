package info.jab.cis194.homework2;

public record LogMessage(MessageType type, int timestamp, String message) implements Entry { }
