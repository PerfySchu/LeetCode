<p>给你一个整数数组 <code>nums</code>。</p>

<p>返回两个（不一定不同的）质数在 <code>nums</code> 中&nbsp;<strong>下标</strong> 的 <strong>最大距离</strong>。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block"> 
 <p><strong>输入：</strong> <span class="example-io">nums = [4,2,9,5,3]</span></p> 
</div>

<p><strong>输出：</strong> <span class="example-io">3</span></p>

<p><strong>解释：</strong> <code>nums[1]</code>、<code>nums[3]</code> 和 <code>nums[4]</code> 是质数。因此答案是 <code>|4 - 1| = 3</code>。</p>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block"> 
 <p><strong>输入：</strong> <span class="example-io">nums = [4,8,2,8]</span></p> 
</div>

<p><strong>输出：</strong> <span class="example-io">0</span></p>

<p><strong>解释：</strong> <code>nums[2]</code> 是质数。因为只有一个质数，所以答案是 <code>|2 - 2| = 0</code>。</p>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>5</sup></code></li> 
 <li><code>1 &lt;= nums[i] &lt;= 100</code></li> 
 <li>输入保证 <code>nums</code> 中至少有一个质数。</li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>数学</li><li>数论</li></div></div><br><div><li>👍 11</li><li>👎 0</li></div>