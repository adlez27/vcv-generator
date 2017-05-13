# VCV Generator
This generator creates VCV/連続音/"triphone" recording lists and OTO configurations for UTAU voicebanks simply from a set of consonants, vowels, and other user specified parameters.

To use, download VCVGen.zip and decompress, then run the VCVGen.jar file.

Consonants: Separate by spaces, ex. "k ky g gy s st str"<br>
Vowels: Separate by spaces, ex. "a i u e o ay ow air eah"<br>
Maximum syllables: Maximum syllables per string.  I recommend setting this to a reasonable amount between 5 - 7, but feel free to use any number you're comfortable with.

Initial Offset: Offset value for the first CV in the string<br>
Tempo: Intended recording tempo.  Many people use 100bpm, because of OREMO's default BGM.<br>
Maximum duplicates: Maximum number of duplicate aliases.  Set to 0 to delete all.  If this is greater than 0, and if there are duplicates in the list, they will be numbered.

Once you press the "Generate" button, your reclist.txt and oto.ini will be in the result folder.

Please note that this generator cannot handle more complex phonetic rules, such as excluding specific consonant+vowel combinations (like yi or wu) or treating certain syllables as vowels in some contexts, but ignoring them otherwise (such as Japanese "n").
