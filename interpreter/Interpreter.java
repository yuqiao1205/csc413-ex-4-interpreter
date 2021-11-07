package interpreter;

import java.io.IOException;

public class Interpreter {

    ByteCodeLoader byteCodeLoader;

    public Interpreter(String codeFile) {
        try {
            CodeTable.init();
            byteCodeLoader = new ByteCodeLoader(codeFile);
        } catch (IOException e) {
            System.out.println("**** " + e);
        }
    }

    void run() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Program program = byteCodeLoader.loadCodes();
        VirtualMachine vm = new VirtualMachine(program);
        vm.executeProgram();
    }

    public static void main(String args[]) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        if (args.length == 0) {
            System.out.println("***Incorrect usage, try: java interpreter.Interpreter <file>");
            System.exit(1);
        }

        (new Interpreter(args[0])).run();
    }

}