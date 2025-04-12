class Solution:
    def reverseWords(self, s: str) -> str:
        words = s.split()
        words = reversed(words)
        return " ".join(words)