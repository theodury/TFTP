package model;

/**
 *
 * @author Theo
 */
public class WriteRequestPacket extends RequestPacket {

	public WriteRequestPacket(String filename, Protocol.Mode mode) {
		super(Protocol.OpCode.WRQ, filename, mode);
	}
}
