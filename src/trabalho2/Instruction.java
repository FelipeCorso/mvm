package trabalho2;

public class Instruction {

    private String instruction;
    private short code;

    public Instruction(String instruction, int code) {
        this.instruction = instruction;
        this.code = Short.parseShort(String.valueOf(code));
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public short getCode() {
        return code;
    }

    public void setCode(short code) {
        this.code = code;
    }

}
