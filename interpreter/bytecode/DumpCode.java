package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.List;

public class DumpCode extends ByteCode {

    private boolean dump;

    public DumpCode() {
    }

    @Override
    public void init(List<String> args) {
        CodeUtils.checkArgs(args, "DUMP", 1);

        dump = args.get(0).equals("ON");
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.setDump(dump);
    }

    @Override
    public void dump(VirtualMachine vm) {

    }
}
