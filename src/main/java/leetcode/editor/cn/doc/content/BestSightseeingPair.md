<p>给你一个正整数数组 <code>values</code>，其中 <code>values[i]</code>&nbsp;表示第 <code>i</code> 个观光景点的评分，并且两个景点&nbsp;<code>i</code> 和&nbsp;<code>j</code>&nbsp;之间的 <strong>距离</strong> 为&nbsp;<code>j - i</code>。</p>

<p>一对景点（<code>i &lt; j</code>）组成的观光组合的得分为 <code>values[i] + values[j] + i - j</code> ，也就是景点的评分之和<strong> 减去 </strong>它们两者之间的距离。</p>

<p>返回一对观光景点能取得的最高分。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>values = [8,1,5,2,6]
<strong>输出：</strong>11
<strong>解释：</strong>i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>values = [1,2]
<strong>输出：</strong>2
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>2 &lt;= values.length &lt;= 5 * 10<sup>4</sup></code></li> 
 <li><code>1 &lt;= values[i] &lt;= 1000</code></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>动态规划</li></div></div><br><div><li>👍 417</li><li>👎 0</li></div>