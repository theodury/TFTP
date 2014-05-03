package model;

/**
 *
 * @author Theo
 */
public class ReadRequestPacket extends RequestPacket {

	public ReadRequestPacket(String filename, Protocol.Mode mode) {
		super(Protocol.OpCode.RRQ, filename, mode);
	}
}
