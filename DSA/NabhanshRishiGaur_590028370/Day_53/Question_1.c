int countGoodSubstrings(char * s) {
    int n = strlen(s);
    int count = 0;

    for (int i = 0; i + 2 < n; i++) {
        char a = s[i], b = s[i+1], c = s[i+2];
        if (a != b && a != c && b != c) {
            count++;
        }
    }

    return count;
}
