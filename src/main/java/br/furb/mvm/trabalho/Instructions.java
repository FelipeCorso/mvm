package br.furb.mvm.trabalho;

import java.util.ArrayList;
import java.util.List;

public class Instructions {

    private final List<Instruction> instructions = new ArrayList<Instruction>();

    private static Instructions uniqueInstance;

    private Instructions() {
        initialize();
    }

    public static synchronized Instructions getInstance() {
        if (uniqueInstance == null) uniqueInstance = new Instructions();

        return uniqueInstance;
    }

    public Instruction getInstruction(String instruction) {
        for (Instruction item : instructions) {
            if (item.getInstruction().equals(instruction)) {
                return item;
            }
        }
        return null;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    private void initialize() {
        instructions.add(new Instruction("init ax", 0));
        instructions.add(new Instruction("move ax,bx", 1));
        instructions.add(new Instruction("move ax,cx", 2));
        instructions.add(new Instruction("move bx,ax", 3));
        instructions.add(new Instruction("move cx,ax", 4));
        instructions.add(new Instruction("move ax,[", 5));
        instructions.add(new Instruction("move ax,[bx+", 6));
        instructions.add(new Instruction("move ax,[bp-", 7));
        instructions.add(new Instruction("move ax,[bp+", 8));
        instructions.add(new Instruction("move [", 9));
        instructions.add(new Instruction("move [bx+", 10));
        instructions.add(new Instruction("move bp,sp", 11));
        instructions.add(new Instruction("move sp,bp", 12));
        instructions.add(new Instruction("add ax,bx", 13));
        instructions.add(new Instruction("add ax,cx", 14));
        instructions.add(new Instruction("add bx,cx", 15));
        instructions.add(new Instruction("sub ax,bx", 16));
        instructions.add(new Instruction("sub ax,cx", 17));
        instructions.add(new Instruction("sub bx,cx", 18));
        instructions.add(new Instruction("inc ax", 19));
        instructions.add(new Instruction("inc bx", 20));
        instructions.add(new Instruction("inc cx", 21));
        instructions.add(new Instruction("dec ax", 22));
        instructions.add(new Instruction("dec bx", 23));
        instructions.add(new Instruction("dec cx", 24));
        instructions.add(new Instruction("test ax0,", 25));
        instructions.add(new Instruction("jmp", 26));
        instructions.add(new Instruction("call", 27));
        instructions.add(new Instruction("ret", 28));
        instructions.add(new Instruction("in ax", 29));
        instructions.add(new Instruction("out ax", 30));
        instructions.add(new Instruction("push ax", 31));
        instructions.add(new Instruction("push bx", 32));
        instructions.add(new Instruction("push cx", 33));
        instructions.add(new Instruction("push bp", 34));
        instructions.add(new Instruction("pop bp", 35));
        instructions.add(new Instruction("pop cx", 36));
        instructions.add(new Instruction("pop bx", 37));
        instructions.add(new Instruction("pop ax", 38));
        instructions.add(new Instruction("nop", 39));
        instructions.add(new Instruction("halt", 40));
        instructions.add(new Instruction("dec sp", 41));
        instructions.add(new Instruction("move [bp-", 42));
        instructions.add(new Instruction("move [bp+", 43));
        instructions.add(new Instruction("move ax,{", 44));
        instructions.add(new Instruction("test axEqbx,", 45));
        instructions.add(new Instruction("inc sp", 46));
        instructions.add(new Instruction("move ax,sp", 47));
        instructions.add(new Instruction("move sp,ax", 48));
        instructions.add(new Instruction("move ax,bp", 49));
        instructions.add(new Instruction("move bp,ax", 50));
        instructions.add(new Instruction("iret", 51));
        instructions.add(new Instruction("int", 52));
        instructions.add(new Instruction("-1", -1)); // Instrução inválida para sair da execução
    }

}
