void main() {
	greet();
}

void greet() {
	IO.print("What's your name? ");
	String name = IO.readln();
	IO.println("Good day, " + name);
	IO.println("Welcome to Java 25.");
}