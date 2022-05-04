package exception;

public class AutoException extends Exception {
    private int errorno;
    private String errormsg;

    public AutoException (int errorno) {
        this.errorno = errorno;
    }

    public int getErrorno () {
        return errorno;
    }

    public String getErrormsg () {
        return errormsg;
    }

    public void setErrorno (int errorno) {
        this.errorno = errorno;
    }

    public void setErrormsg (String errormsg) {
        this.errormsg = errormsg;
    }

    public String fix () {
        Fix100to600 e = new Fix100to600();
        switch (errorno) {
            case 101:
                errormsg = "Missing file name";
                break;
            case 201:
                errormsg = "Missing base price";
                break;
            case 301:
                errormsg = "Missing option set array size";
                break;
            case 401:
                errormsg = "Missing option set name";
                break;
            case 501:
                errormsg = "Missing option name";
                break;
        }
        log();
        return e.fix();
    }

    public void log() {
        System.out.printf("\n~~~~~~~Error %d: %s\n", errorno, errormsg);
    }
}
