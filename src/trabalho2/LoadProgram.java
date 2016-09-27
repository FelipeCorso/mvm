package trabalho2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import mvm.MVM;

/**
 * 
 * @author felipe.corso
 */
public class LoadProgram {

    private static final String MOVE_TO_AX_VALUE_MEMORY_POSITION = "move ax,\\[(\\d)\\]"; // move ax,[
    private static final String MOVE_TO_AX_VALUE_MEMORY_POSITION_BX_PLUS = "move ax,\\[bx\\+(\\d)\\]";// move ax,[bx+
    private static final String MOVE_TO_AX_VALUE_MEMORY_POSITION_BP_MINUS = "move ax,\\[bp\\-(\\d)\\]";// move ax,[bp-
    private static final String MOVE_TO_AX_VALUE_MEMORY_POSITION_BP_PLUS = "move ax,\\[bp\\+(\\d)\\]";// move ax,[bp+
    private static final String MOVE_AX_TO_MEMORY_POSITION = "move \\[(\\d)\\],ax";// move [
    private static final String MOVE_AX_TO_MEMORY_POSITION_BX_PLUS = "move \\[bx\\+(\\d)\\],ax";// move [bx+
    private static final String TEST_AX0 = "test ax0,(\\d)";// test ax0,
    private static final String JMP = "jmp (\\d)";// jmp
    private static final String CALL = "call (\\d)";// call
    private static final String MOVE_AX_TO_MEMORY_POSITION_BP_MINUS = "move \\[bp\\-(\\d)\\],ax";// move [bp-3], ax
    private static final String MOVE_AX_TO_MEMORY_POSITION_BP_PLUS = "move \\[bp\\+(\\d)\\],ax";// move [bp+3], ax
    private static final String MOVE_TO_AX_VALUE = "move ax,\\{(\\d)\\}";// move ax,{
    private static final String TEST_AX_EQ_BX = "test axEqbx,(\\d)";// test axEqbx,
    private static final String INT = "int (\\d)";// int

    private Instructions instructions = new Instructions();

    public static void main(String[] args) {
        try {
            short mem[] = new short[1025];

            LoadProgram main = new LoadProgram();
            String path = "C:/Users/fcorso/Downloads/SO_EX1.txt";
            File file = new File(path);
            BufferedReader bufferFileSrc = main.readFile(file);
            mem = main.readLines(bufferFileSrc);
            bufferFileSrc.close();
            MVM.decodificador(mem, 0, 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BufferedReader readFile(File file) throws FileNotFoundException, IOException {
        return new BufferedReader(new FileReader(file));
    }

    public short[] readLines(BufferedReader src) throws IOException {
        short mem[] = new short[1025];
        int loadAddress = 0;
        String line;
        while ((line = src.readLine()) != null) {
            line = line.trim();
            Instruction instruction = instructions.getInstruction(line);

            if (instruction != null) {
                mem[loadAddress] = instruction.getCode();
            } else {
                Matcher matcher = Pattern.compile(MOVE_TO_AX_VALUE_MEMORY_POSITION).matcher(line);
                if (matcher.matches()) {
                    mem[loadAddress] = 5;
                    loadAddress++;
                    mem[loadAddress] = Short.parseShort(matcher.group(1));
                } else {
                    matcher = Pattern.compile(MOVE_TO_AX_VALUE_MEMORY_POSITION_BX_PLUS).matcher(line);
                    if (matcher.matches()) {
                        mem[loadAddress] = 6;
                        loadAddress++;
                        mem[loadAddress] = Short.parseShort(matcher.group(1));
                    } else {
                        matcher = Pattern.compile(MOVE_TO_AX_VALUE_MEMORY_POSITION_BP_MINUS).matcher(line);
                        if (matcher.matches()) {
                            mem[loadAddress] = 7;
                            loadAddress++;
                            mem[loadAddress] = Short.parseShort(matcher.group(1));
                        } else {
                            matcher = Pattern.compile(MOVE_TO_AX_VALUE_MEMORY_POSITION_BP_PLUS).matcher(line);
                            if (matcher.matches()) {
                                mem[loadAddress] = 8;
                                loadAddress++;
                                mem[loadAddress] = Short.parseShort(matcher.group(1));
                            } else {
                                matcher = Pattern.compile(MOVE_AX_TO_MEMORY_POSITION).matcher(line);
                                if (matcher.matches()) {
                                    mem[loadAddress] = 9;
                                    loadAddress++;
                                    mem[loadAddress] = Short.parseShort(matcher.group(1));
                                } else {
                                    matcher = Pattern.compile(MOVE_AX_TO_MEMORY_POSITION_BX_PLUS).matcher(line);
                                    if (matcher.matches()) {
                                        mem[loadAddress] = 10;
                                        loadAddress++;
                                        mem[loadAddress] = Short.parseShort(matcher.group(1));
                                    } else {
                                        matcher = Pattern.compile(TEST_AX0).matcher(line);
                                        if (matcher.matches()) {
                                            mem[loadAddress] = 25;
                                            loadAddress++;
                                            mem[loadAddress] = Short.parseShort(matcher.group(1));
                                        } else {
                                            matcher = Pattern.compile(JMP).matcher(line);
                                            if (matcher.matches()) {
                                                mem[loadAddress] = 26;
                                                loadAddress++;
                                                mem[loadAddress] = Short.parseShort(matcher.group(1));
                                            } else {
                                                matcher = Pattern.compile(CALL).matcher(line);
                                                if (matcher.matches()) {
                                                    mem[loadAddress] = 27;
                                                    loadAddress++;
                                                    mem[loadAddress] = Short.parseShort(matcher.group(1));
                                                } else {
                                                    matcher = Pattern.compile(MOVE_AX_TO_MEMORY_POSITION_BP_MINUS).matcher(line);
                                                    if (matcher.matches()) {
                                                        mem[loadAddress] = 42;
                                                        loadAddress++;
                                                        mem[loadAddress] = Short.parseShort(matcher.group(1));
                                                    } else {
                                                        matcher = Pattern.compile(MOVE_AX_TO_MEMORY_POSITION_BP_PLUS).matcher(line);
                                                        if (matcher.matches()) {
                                                            mem[loadAddress] = 43;
                                                            loadAddress++;
                                                            mem[loadAddress] = Short.parseShort(matcher.group(1));
                                                        } else {
                                                            matcher = Pattern.compile(MOVE_TO_AX_VALUE).matcher(line);
                                                            if (matcher.matches()) {
                                                                mem[loadAddress] = 44;
                                                                loadAddress++;
                                                                mem[loadAddress] = Short.parseShort(matcher.group(1));
                                                            } else {
                                                                matcher = Pattern.compile(TEST_AX_EQ_BX).matcher(line);
                                                                if (matcher.matches()) {
                                                                    mem[loadAddress] = 45;
                                                                    loadAddress++;
                                                                    mem[loadAddress] = Short.parseShort(matcher.group(1));
                                                                }else{
                                                                	matcher = Pattern.compile(INT).matcher(line);
                                                                    if (matcher.matches()) {
                                                                        mem[loadAddress] = 52;
                                                                        loadAddress++;
                                                                        mem[loadAddress] = Short.parseShort(matcher.group(1));
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            loadAddress++;
        }

        return mem;
    }
}
