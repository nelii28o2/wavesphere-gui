package edu.uprm.icom5217.wave.xbee;

public enum XbeeCommands {

	 ID('0'),
	 RETRIEVAL_MODE('1'),
	 SHUTDOWN_MODE('2'),
	 SAMPLING_MODE('3'),
	 STOP_LOCATE_MODE('4'),
	 DIAGNOSTIC_MODE('5'),
	 STOP_DIAGNOSTIC_MODE('6'),
	 STATUS_MODE('7');
	 
	 private final char command;
	 
	 private XbeeCommands(char command)
	 {
		 this.command = command;
	 }
	 
	 public char getCommand()
	 {
		 return command;
	 }
}
