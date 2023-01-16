<p>一个句子是由一些单词与它们之间的单个空格组成，且句子的开头和结尾没有多余空格。比方说，<code>"Hello World"</code>&nbsp;，<code>"HELLO"</code>&nbsp;，<code>"hello world hello world"</code>&nbsp;都是句子。每个单词都 <strong>只</strong>&nbsp;包含大写和小写英文字母。</p>

<p>如果两个句子&nbsp;<code>sentence1</code> 和&nbsp;<code>sentence2</code>&nbsp;，可以通过往其中一个句子插入一个任意的句子（<strong>可以是空句子</strong>）而得到另一个句子，那么我们称这两个句子是 <strong>相似的</strong>&nbsp;。比方说，<code>sentence1 = "Hello my name is Jane"</code> 且&nbsp;<code>sentence2 = "Hello Jane"</code>&nbsp;，我们可以往 <code>sentence2</code>&nbsp;中&nbsp;<code>"Hello"</code> 和&nbsp;<code>"Jane"</code>&nbsp;之间插入&nbsp;<code>"my name is"</code>&nbsp;得到 <code>sentence1</code>&nbsp;。</p>

<p>给你两个句子&nbsp;<code>sentence1</code> 和&nbsp;<code>sentence2</code>&nbsp;，如果<em>&nbsp;</em><code>sentence1</code> 和<em>&nbsp;</em><code>sentence2</code> 是相似的，请你返回&nbsp;<code>true</code>&nbsp;，否则返回&nbsp;<code>false</code>&nbsp;。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><b>输入：</b>sentence1 = "My name is Haley", sentence2 = "My Haley"
<b>输出：</b>true
<b>解释：</b>可以往 sentence2 中 "My" 和 "Haley" 之间插入 "name is" ，得到 sentence1 。
</pre>

<p><strong>示例 2：</strong></p>

<pre><b>输入：</b>sentence1 = "of", sentence2 = "A lot of words"
<b>输出：</b>false
<strong>解释：</strong>没法往这两个句子中的一个句子只插入一个句子就得到另一个句子。
</pre>

<p><strong>示例 3：</strong></p>

<pre><b>输入：</b>sentence1 = "Eating right now", sentence2 = "Eating"
<b>输出：</b>true
<b>解释：</b>可以往 sentence2 的结尾插入 "right now" 得到 sentence1 。
</pre>

<p><strong>示例 4：</strong></p>

<pre><b>输入：</b>sentence1 = "Luky", sentence2 = "Lucccky"
<b>输出：</b>false
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= sentence1.length, sentence2.length &lt;= 100</code></li> 
 <li><code>sentence1</code>&nbsp;和&nbsp;<code>sentence2</code>&nbsp;都只包含大小写英文字母和空格。</li> 
 <li><code>sentence1</code>&nbsp;和&nbsp;<code>sentence2</code>&nbsp;中的单词都只由单个空格隔开。</li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>双指针</li><li>字符串</li></div></div><br><div><li>👍 64</li><li>👎 0</li></div>