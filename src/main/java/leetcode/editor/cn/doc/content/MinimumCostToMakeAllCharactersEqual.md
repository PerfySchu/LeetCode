<p>给你一个下标从 <strong>0</strong> 开始、长度为 <code>n</code> 的二进制字符串 <code>s</code> ，你可以对其执行两种操作：</p>

<ul> 
 <li>选中一个下标 <code>i</code> 并且反转从下标 <code>0</code> 到下标 <code>i</code>（包括下标 <code>0</code> 和下标 <code>i</code> ）的所有字符，成本为 <code>i + 1</code> 。</li> 
 <li>选中一个下标 <code>i</code> 并且反转从下标 <code>i</code> 到下标 <code>n - 1</code>（包括下标 <code>i</code> 和下标 <code>n - 1</code> ）的所有字符，成本为 <code>n - i</code> 。</li> 
</ul>

<p>返回使字符串内所有字符 <strong>相等</strong> 需要的 <strong>最小成本</strong> 。</p>

<p><strong>反转</strong> 字符意味着：如果原来的值是 '0' ，则反转后值变为 '1' ，反之亦然。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>s = "0011"
<strong>输出：</strong>2
<strong>解释：</strong>执行第二种操作，选中下标 <span><code>i = 2</code></span> ，可以得到 <span><code>s = "0000" ，成本为 2</code></span> 。可以证明 2 是使所有字符相等的最小成本。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>s = "010101"
<strong>输出：</strong>9
<strong>解释：</strong>执行第一种操作，选中下标 i = 2 ，可以得到 s = "101101" ，成本为 3 。
执行第一种操作，选中下标 i = 1 ，可以得到 s = "011101" ，成本为 2 。
执行第一种操作，选中下标 i = 0 ，可以得到 s = "111101" ，成本为 1 。
执行第二种操作，选中下标 i = 4 ，可以得到 s = "111110" ，成本为 2 。
执行第二种操作，选中下标 i = 5 ，可以得到 s = "111111" ，成本为 1 。
使所有字符相等的总成本等于 9 。可以证明 9 是使所有字符相等的最小成本。 </pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= s.length == n &lt;= 10<sup>5</sup></code></li> 
 <li><code>s[i]</code> 为 <code>'0'</code> 或 <code>'1'</code></li> 
</ul>

<div><div>Related Topics</div><div><li>贪心</li><li>字符串</li><li>动态规划</li></div></div><br><div><li>👍 69</li><li>👎 0</li></div>