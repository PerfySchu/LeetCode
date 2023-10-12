//2023-10-12 10:06:34
//第2562题
//给你一个下标从 0 开始的整数数组 nums 。
//
// 现定义两个数字的 串联 是由这两个数值串联起来形成的新数字。
//
//
// 例如，15 和 49 的串联是 1549 。
//
//
// nums 的 串联值 最初等于 0 。执行下述操作直到 nums 变为空：
//
//
// 如果 nums 中存在不止一个数字，分别选中 nums 中的第一个元素和最后一个元素，将二者串联得到的值加到 nums 的 串联值 上，然后从 nums
//中删除第一个和最后一个元素。
// 如果仅存在一个元素，则将该元素的值加到 nums 的串联值上，然后删除这个元素。
//
//
// 返回执行完所有操作后 nums 的串联值。
//
//
//
// 示例 1：
//
//
//输入：nums = [7,52,2,4]
//输出：596
//解释：在执行任一步操作前，nums 为 [7,52,2,4] ，串联值为 0 。
// - 在第一步操作中：
//我们选中第一个元素 7 和最后一个元素 4 。
//二者的串联是 74 ，将其加到串联值上，所以串联值等于 74 。
//接着我们从 nums 中移除这两个元素，所以 nums 变为 [52,2] 。
// - 在第二步操作中：
//我们选中第一个元素 52 和最后一个元素 2 。
//二者的串联是 522 ，将其加到串联值上，所以串联值等于 596 。
//接着我们从 nums 中移除这两个元素，所以 nums 变为空。
//由于串联值等于 596 ，所以答案就是 596 。
//
//
// 示例 2：
//
//
//输入：nums = [5,14,13,8,12]
//输出：673
//解释：在执行任一步操作前，nums 为 [5,14,13,8,12] ，串联值为 0 。
//- 在第一步操作中：
//我们选中第一个元素 5 和最后一个元素 12 。
//二者的串联是 512 ，将其加到串联值上，所以串联值等于 512 。
//接着我们从 nums 中移除这两个元素，所以 nums 变为 [14,13,8] 。
//- 在第二步操作中：
//我们选中第一个元素 14 和最后一个元素 8 。
//二者的串联是 148 ，将其加到串联值上，所以串联值等于 660 。
//接着我们从 nums 中移除这两个元素，所以 nums 变为 [13] 。
//- 在第三步操作中：
//nums 只有一个元素，所以我们选中 13 并将其加到串联值上，所以串联值等于 673 。
//接着我们从 nums 中移除这个元素，所以 nums 变为空。
//由于串联值等于 673 ，所以答案就是 673 。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 1000
// 1 <= nums[i] <= 10⁴
//
//
// Related Topics 数组 双指针 模拟 👍 25 👎 0

package leetcode.editor.cn;
public class FindTheArrayConcatenationValue{
    public static void main(String[] args){
        Solution solution = new FindTheArrayConcatenationValue().new Solution();
        System.out.println(solution.findTheArrayConcVal(new int[]{7,52,2,4}));
        System.out.println(solution.findTheArrayConcVal(new int[]{5,14,13,8,12}));
        //22492401084
        System.out.println(solution.findTheArrayConcVal(new int[]{3432,1461,9408,1439,2367,7539,2927,1015,5397,8879,6827,4187,524,4113,7001,1300,9667,2058,4258,4406,2469,2774,573,7398,9586,6870,7355,4020,6147,5830,3953,6760,1786,5161,5919,7692,23,9298,4719,9116,4637,487,9865,9222,309,6642,6707,3603,3914,4549,8037,6815,6730,3256,5081,7388,5339,5956,5857,3933,8948,94,6793,5300,7199,3989,4371,4013,5622,5433,3157,8211,532,2249,7579,1074,8921,4570,9082,1279,4940,1616,6683,89,8620,9859,727,6688,801,9045,8488,7193,8972,597,8881,8163,7410,640,9424,5487,4823,4968,6647,2037,8535,8826,5583,8041,3650,4036,971,3350,3832,9908,1889,7753,7671,1872,5011,6872,3268,2253,9001,8491,7841,1749,7600,3885,1693,4690,9461,9283,2497,1129,1552,7392,9360,879,158,7077,695,6910,463,4782,8278,688,537,9359,285,2070,4984,7337,891,8877,8111,8084,5614,400,565,2404,2547,1996,9896,438,8499,1542,2358,7657,7397,9974,8929,5349,3398,6553,5431,3271,9861,7441,6113,5526,1172,1928,3370,4326,2738,2977,1113,7514,872,5017,9110,2921,1288,4935,8882,4149,3412,9310,4724,3934,3461,1535,3922,9830,2168,2311,5824,812,488,9410,8932,8443,9219,3191,6357,5076,1538,7770,9231,7180,3660,3763,9257,9867,2762,646,434,1573,7078,3720,9344,3484,1530,8371,9568,1439,1400,8156,4992,2426,7237,9327,4862,233,4780,5183,2081,2650,1100,6716,9172,1642,8627,8484,228,5552,4985,1147,4569,3923,9303,6351,6447,223,8133,2192,271,2124,2538,388,7546,511,2794,2749,8988,5536,2601,3177,7677,6478,8675,3724,3052,3015,5609,1423,6050,1382,2268,8493,3719,1905,2953,8659,4198,7663,6942,2259,4454,9622,4714,3343,6915,1984,4801,7105,9255,3593,1932,3520,5873,4256,4061,7356,3775,9749,7354,9568,3588,102,3715,9386,230,9696,774,3773,4104,2006,5802,1810,6829,8847,5033,3840,392,1672,4402,6050,3410,1956,5133,3880,5474,7564,7054,8121,3431,3208,6244,9260,5181,4164,1984,6612,7913,6550,1060,7443,7381,2853,6211,3906,7023,4181,6299,7903,5175,3849,4080,8785,9875,5620,1576,8175,4784,7845,5883,3661,791,5462,3525,522,4945,7429,9668,7678,814,2859,6370,9661,8474,1424,9853,9906,7314,2471,4425,8959,4620,1596,7765,2092,288,4232,478,5664,6933,5995,3546,723,9815,9082,7733,657,1429,4183,747,4420,6434,362,8079,750,1805,7713,1888,4032,951,2790,581,5435,3303,7467,9411,7199,2940,1075,2555,6867,4834,9135,5887,5540,540,4590,6145,6870,5160,6699,9873,1932,4874,5021,3526,8793,8828,773,7086,9672,9394,6859,2473,1610,9800,81,5363,1969,3598,1878,5688,4353,8760,5550,2155,7161,4911,913,2383,2986,9825,9607,6510,2465,456,1063,5836,2962,977,5141,7049,705,9190,7824,4960,734,9236,6672,9052,419,7635,2227,1592,4073,6638,7304,1463,6513,4787,3424,9019,8091,5441,2247,1497,4417,1949,5518,6808,1160,4885,9477,7509,4244,6764,8506,4932,4228,2680,9963,548,9283,1721,5899,3436,3679,2720,1430,1364,8960,4229,8017,7277,4814,5261,1622,5145,2680,8147,9569,305,5561,9334,5169,24,412,6650,5170,9198,507,7581,1862,4234,1122,1215,456,6344,5682,4857,5848,1785,1310,8954,3885,8833,6722,1090,2262,4093,4032,2338,5617,3441,2966,7284,5296,9938,402,9340,4006,2012,6669,1874,7166,7151,6686,512,1032,8140,1022,697,3412,11,8091,1196,5026,7601,6989,716,8410,9036,6649,944,4269,4671,9003,8882,2829,3517,2713,6053,6059,8578,2904,769,4921,7810,2616,3537,3358,7393,2713,8966,7608,2584,2033,4159,2800,6705,4644,4449,5889,577,6525,497,4717,4286,6969,2261,9721,3298,8569,2696,5846,7004,3186,7047,6653,4204,7508,2464,3421,6298,5511,744,8172,4855,247,8392,1572,4800,6901,7707,920,6424,8833,2763,1722,3737,9968,5673,1983,8507,2672,6232,6758,1198,7594,4612,3327,523,6181,1310,9137,2833,2933,1801,2121,5125,7261,3770,742,2874,4764,3855,4696,7493,9605,6350,9772,1996,1285,9608,1718,332,1428,6018,9233,7993,3044,8903,5834,5581,8812,8771,3641,1312,7095,752,5586,4065,6602,3531,6993,4688,1089,1125,2611,1694,6943,836,2741,3270,5854,3964,6008,6805,2703,2458,5808,4970,3883,2401,1482,8767,8331,1454,8548,4797,1723,1168,5359,3444,9377,6870,1054,6059,1279,8379,661,4421,9556,9406,6447,1021,9957,6854,6418,4437,823,7740,5353,505,6628,4371,8435,3522,3558,9727,1436,9870,6630,170,3004,177,4056,7777,3275,2951,4068,5715,711,7459,7457,4898,4242,3447,7891,4854,147,6923,6766,5442,2256,6359,4475,4604,1247,419,849,382,6450,4912,255,5413,6300,4092,4579,3399,7172,3512,1416,3464,4552,957,7749,4305,2004,4526,1755,1535,5300,7420,2078,3142,5686,3655,6227,6404,6292,7066,9880,9676,7525,1011,5479,4197,6086,5214,6789,4218,6803,2450,8007,5411,469,6701,8722,909,3124,726,5209,5043,3426,9447,4086,2447,6114,1667,7530,9753,5543,2616,2029,8594,1899,3085,7026,3048,3719,9577,1729,1,9914,4356,2647,6911,6627,321,5926,585,6501,9220,1430,5523,7909,8280,5910,5631,6393,1905,1724,7011,7655,4027,8768,9409,4316,3827,2693,67,7677,9314,7274,6410,2204,35,2547,2331,328,4840,9772,8495,4602,6434,8003,2811,9249,108,2219,8873,4420,7478,5859,6856,9604,6579,2455,4319,6138,9122,4054,5068,7585,1776,7657,7659,7032,9653,2047,2271,7592,322,5487,8725,1542,56,2517,6734,944,439,4822,2922,3162,8662,5150,1030,3057,273,3802,9569,1094,6671,8299,8628,2418,8288,3984,316,8831,5280,6904,1256,4281,1645,9120,508,9920,9295,4365,7363,2387}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long ans = 0;
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            if(left == right){
                ans += nums[left];
            }else {
                ans += Integer.parseInt(nums[left] + "" + nums[right]);
            }
            left++;
            right--;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}