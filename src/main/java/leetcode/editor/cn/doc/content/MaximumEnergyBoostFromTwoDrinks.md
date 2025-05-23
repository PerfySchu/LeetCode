<p>来自未来的体育科学家给你两个整数数组 <code>energyDrinkA</code> 和 <code>energyDrinkB</code>，数组长度都等于 <code>n</code>。这两个数组分别代表 A、B 两种不同能量饮料每小时所能提供的强化能量。</p>

<p>你需要每小时饮用一种能量饮料来 <strong>最大化 </strong>你的总强化能量。然而，如果从一种能量饮料切换到另一种，你需要等待一小时来梳理身体的能量体系（在那个小时里你将不会获得任何强化能量）。</p>

<p>返回在接下来的 <code>n</code> 小时内你能获得的<strong> 最大 </strong>总强化能量。</p>

<p><strong>注意 </strong>你可以选择从饮用任意一种能量饮料开始。</p>

<p>&nbsp;</p>

<p><strong class="example">示例 1：</strong></p>

<div class="example-block"> 
 <p><strong>输入：</strong>energyDrinkA<span class="example-io"> = [1,3,1], </span>energyDrinkB<span class="example-io"> = [3,1,1]</span></p> 
</div>

<p><strong>输出：</strong><span class="example-io">5</span></p>

<p><strong>解释：</strong></p>

<p>要想获得 5 点强化能量，需要选择只饮用能量饮料 A（或者只饮用 B）。</p>

<p><strong class="example">示例 2：</strong></p>

<div class="example-block"> 
 <p><strong>输入：</strong>energyDrinkA<span class="example-io"> = [4,1,1], </span>energyDrinkB<span class="example-io"> = [1,1,3]</span></p> 
</div>

<p><strong>输出：</strong><span class="example-io">7</span></p>

<p><strong>解释：</strong></p>

<ul> 
 <li>第一个小时饮用能量饮料 A。</li> 
 <li>切换到能量饮料 B ，在第二个小时无法获得强化能量。</li> 
 <li>第三个小时饮用能量饮料 B ，并获得强化能量。</li> 
</ul>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul> 
 <li><code>n == energyDrinkA.length == energyDrinkB.length</code></li> 
 <li><code>3 &lt;= n &lt;= 10<sup>5</sup></code></li> 
 <li><code>1 &lt;= energyDrinkA[i], energyDrinkB[i] &lt;= 10<sup>5</sup></code></li> 
</ul>

<div><div>Related Topics</div><div><li>数组</li><li>动态规划</li></div></div><br><div><li>👍 24</li><li>👎 0</li></div>