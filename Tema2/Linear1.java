public boolean equalTo(String[] a, String[] b) {
        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (!(a[i].equals(b[i]))) {
                return false;
            }
        }
        return true;
    }