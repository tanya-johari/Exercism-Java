class RnaTranscription {

    String transcribe(String dnaStrand) {
        StringBuilder sb = new StringBuilder(dnaStrand.length());

        for (char c : dnaStrand.toCharArray()) {
            sb.append(transcribeBase(c));
        }
        return sb.toString();
    }

    public static char transcribeBase(char base) {
        return switch (base) {
            case 'G' -> 'C';
            case 'C' -> 'G';
            case 'T' -> 'A';
            case 'A' -> 'U';
            default -> ' ';
        };
    }
}
