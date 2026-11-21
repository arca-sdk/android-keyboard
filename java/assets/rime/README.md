# RIME data bundled with the app

`terra_pinyin.dict.yaml` is the Terra Pinyin (地球拼音) dictionary from
https://github.com/rime/rime-terra-pinyin, unmodified, at commit
723e51bc266cf9464530c1ddedb856aa18e3da34. It is licensed under the LGPL-3.0, see [LICENSE](LICENSE).

Zhuyin input uses it because it marks the tone of each syllable, which the Luna Pinyin dictionary
from the Chinese dictionary download doesn't. `ChineseZhuyin.kt` copies it into RIME's user
directory.
