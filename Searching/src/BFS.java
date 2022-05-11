
public class BFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int [] A= {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 208, 209, 210, 211, 212, 213, 214, 215, 216, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254, 255, 256, 257, 258, 259, 260, 261, 262, 263, 264, 265, 266, 267, 268, 269, 270, 271, 272, 273, 274, 275, 276, 277, 278, 279, 280, 281, 283, 284, 285, 286, 287, 289, 290, 291, 292, 293, 294, 295, 296, 297, 298, 299, 300, 301, 302, 303, 304, 305, 306, 307, 309, 310, 311, 312, 313, 314, 315, 316, 317, 318, 319, 320, 321, 322, 324, 325, 326, 328, 329, 330, 331, 332, 333, 335, 336, 337, 338, 339, 340, 341, 342, 343, 344, 345, 346, 347, 348, 349, 350, 351, 352, 353, 354, 355, 356, 357, 358, 359, 360, 361, 362, 363, 364, 365, 366, 367, 368, 369, 370, 371, 372, 373, 374, 375, 376, 377, 378, 379, 380, 381, 382, 383, 384, 385, 386, 387, 388, 389, 390, 391, 392, 393, 394, 395, 396, 397, 398, 399, 400, 401, 402, 403, 404, 405, 406, 407, 408, 409, 410, 411, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422, 423, 424, 425, 426, 427, 428, 429, 430, 431, 432, 433, 434, 435, 436, 437, 438, 440, 442, 443, 444, 445, 446, 447, 448, 449, 450, 451, 452, 453, 454, 455, 456, 457, 458, 459, 460, 461, 462, 463, 464, 465, 466, 467, 468, 469, 470, 471, 472, 473, 474, 475, 476, 477, 478, 479, 480, 481, 482, 483, 484, 485, 486, 487, 488, 489, 490, 491, 492, 493, 494, 495, 496, 497, 498, 499, 500, 501, 502, 503, 504, 505, 506, 507, 508, 509, 510, 511, 512, 513, 514, 515, 516, 517, 518, 519, 520, 521, 522, 523, 524, 525, 526, 527, 528, 529, 530, 531, 532, 533, 534, 535, 536, 537, 538, 539, 540, 541, 542, 543, 544, 546, 547, 548, 549, 550, 551, 552, 553, 554, 555, 556, 557, 558, 559, 560, 561, 562, 563, 564, 566, 567, 568, 569, 570, 571, 572, 573, 574, 575, 576, 577, 578, 579, 580, 581, 582, 583, 584, 585, 586, 587, 588, 589, 590, 591, 592, 593, 594, 595, 596, 597, 598, 599, 600, 601, 602, 603, 604, 605, 606, 607, 608, 609, 610, 611, 612, 613, 614, 615, 616, 617, 618, 619, 620, 621, 622, 623, 625, 626, 627, 628, 629, 630, 631, 632, 633, 634, 635, 636, 638, 639, 640, 641, 643, 644, 645, 646, 647, 648, 649, 650, 651, 652, 653, 654, 655, 656, 657, 658, 659, 660, 661, 662, 663, 664, 665, 666, 667, 668, 669, 670, 672, 673, 674, 675, 676, 677, 678, 679, 680, 681, 682, 683, 684, 685, 686, 687, 688, 689, 690, 691, 692, 693, 694, 695, 696, 697, 698, 699, 700, 701, 702, 703, 704, 705, 706, 707, 708, 709, 710, 711, 712, 713, 714, 715, 717, 718, 719, 720, 721, 722, 723, 724, 725, 726, 727, 728, 729, 730, 731, 732, 733, 734, 735, 736, 737, 739, 740, 741, 742, 743, 744, 745, 746, 747, 748, 749, 750, 751, 752, 753, 754, 755, 756, 757, 758, 759, 760, 761, 762, 763, 764, 765, 766, 767, 768, 769, 770, 771, 772, 773, 774, 775, 776, 777, 778, 779, 780, 781, 782, 783, 784, 785, 786, 787, 788, 789, 790, 791, 792, 793, 794, 795, 796, 797, 798, 799, 800, 801, 802, 803, 804, 805, 806, 807, 808, 809, 810, 811, 812, 813, 814, 815, 816, 817, 818, 819, 820, 821, 822, 823, 824, 825, 826, 827, 828, 829, 830, 831, 832, 833, 834, 835, 836, 837, 838, 839, 840, 841, 842, 843, 844, 845, 846, 847, 848, 849, 850, 851, 852, 853, 854, 855, 856, 857, 858, 859, 861, 863, 864, 865, 866, 867, 868, 869, 870, 871, 872, 873, 874, 875, 876, 877, 878, 879, 880, 881, 882, 883, 884, 885, 886, 887, 888, 889, 890, 891, 892, 893, 894, 895, 896, 897, 898, 899, 900, 901, 902, 903, 904, 905, 906, 907, 908, 909, 910, 911, 912, 913, 914, 915, 916, 917, 918, 919, 920, 921, 922, 923, 924, 925, 926, 927, 928, 929, 930, 931, 932, 933, 934, 935, 936, 937, 938, 939, 940, 941, 942, 943, 944, 945, 946, 947, 948, 949, 950, 951, 952, 953, 954, 955, 956, 957, 958, 959, 960, 961, 962, 963, 964, 965, 966, 967, 968, 969, 970, 971, 972, 973, 974, 975, 976, 977, 978, 979, 980, 981, 982, 983, 984, 985, 986, 987, 988, 989, 990, 991, 992, 993, 994, 995, 996, 997, 998, 999, 1000, 1001};
//		int [] A= {3, 4, 18, 19, 20, 27, 28, 31, 36, 42, 44, 71, 72, 75, 82, 86, 88, 97, 100, 103, 105, 107, 110, 116, 118, 119, 121, 122, 140, 141, 142, 155, 157, 166, 176, 184, 190, 199, 201, 210, 212, 220, 225, 234, 235, 236, 238, 244, 259, 265, 266, 280, 283, 285, 293, 299, 309, 312, 317, 335, 341, 352, 354, 360, 365, 368, 370, 379, 386, 391, 400, 405, 410, 414, 416, 428, 433, 437, 438, 445, 453, 457, 458, 472, 476, 480, 485, 489, 491, 493, 501, 502, 505, 510, 511, 520, 526, 535, 557, 574, 593, 595, 604, 605, 612, 629, 632, 633, 634, 642, 647, 653, 654, 656, 658, 686, 689, 690, 691, 709, 716, 717, 737, 738, 746, 759, 765, 775, 778, 783, 786, 787, 791, 797, 801, 806, 815, 820, 822, 823, 832, 839, 841, 847, 859, 873, 877, 880, 886, 904, 909, 911, 917, 919, 937, 946, 948, 951, 961, 971, 979, 980, 986, 993};
//		int [] A= {1};
		int [] A = {17, 30, 32, 69, 94, 96, 106, 118, 127, 159, 169, 170, 178, 183, 209, 238, 242, 247, 253, 261, 265, 279, 288, 302, 305, 316, 352, 357, 374, 376, 392, 402, 410, 421, 439, 442, 444, 446, 454, 458, 464, 467, 468, 498, 500, 513, 523, 541, 545, 556, 575, 608, 616, 629, 631, 635, 669, 674, 682, 686, 693, 695, 719, 733, 754, 755, 756, 778, 802, 822, 824, 828, 835, 847, 848, 862, 864, 878, 883, 885, 904, 908, 928, 934};
//		int [] A= {3, 4, 6, 7, 8, 18, 20, 21, 22, 23, 26, 27, 28, 29, 32, 38, 39, 40, 42, 46, 49, 53, 54, 55, 59, 61, 64, 66, 69, 76, 77, 80, 83, 93, 94, 95, 96, 98, 101, 102, 103, 105, 108, 110, 112, 114, 115, 117, 119, 121, 122, 125, 126, 127, 131, 134, 136, 137, 139, 142, 144, 146, 147, 148, 150, 151, 152, 154, 156, 158, 159, 160, 161, 163, 166, 172, 173, 174, 175, 178, 179, 184, 186, 187, 189, 190, 195, 196, 197, 198, 200, 202, 204, 207, 208, 209, 211, 212, 215, 218, 219, 223, 230, 235, 236, 237, 238, 239, 241, 242, 244, 246, 250, 251, 252, 254, 256, 257, 258, 259, 260, 261, 267, 268, 271, 273, 275, 276, 278, 281, 284, 287, 288, 289, 294, 296, 299, 301, 304, 307, 309, 311, 314, 317, 318, 322, 325, 327, 331, 333, 334, 335, 339, 340, 342, 344, 345, 347, 348, 349, 352, 353, 354, 355, 357, 359, 361, 364, 365, 368, 374, 376, 378, 381, 383, 385, 386, 391, 393, 402, 408, 409, 410, 412, 415, 416, 419, 420, 421, 424, 426, 427, 429, 430, 433, 436, 437, 439, 441, 442, 444, 445, 452, 453, 456, 457, 458, 462, 466, 467, 468, 470, 473, 474, 475, 476, 477, 478, 479, 481, 483, 484, 485, 487, 488, 489, 497, 500, 501, 503, 504, 505, 507, 509, 510, 514, 515, 517, 518, 520, 521, 522, 523, 524, 525, 526, 531, 532, 534, 538, 539, 543, 544, 546, 548, 550, 554, 556, 557, 558, 559, 564, 567, 568, 569, 571, 574, 577, 580, 582, 583, 584, 591, 592, 593, 595, 597, 598, 600, 604, 606, 608, 609, 610, 612, 613, 614, 615, 616, 617, 619, 620, 623, 625, 634, 636, 637, 640, 643, 644, 646, 647, 650, 651, 656, 658, 659, 660, 662, 665, 666, 668, 672, 674, 678, 680, 684, 685, 688, 689, 690, 692, 694, 697, 701, 702, 705, 706, 709, 711, 712, 716, 719, 721, 727, 728, 730, 732, 734, 735, 736, 737, 740, 742, 743, 746, 747, 752, 754, 755, 757, 759, 761, 764, 765, 767, 769, 771, 772, 774, 775, 777, 778, 779, 780, 781, 784, 787, 792, 793, 797, 799, 800, 801, 803, 806, 807, 810, 813, 815, 823, 824, 827, 828, 830, 831, 832, 833, 834, 838, 841, 843, 847, 848, 849, 853, 854, 855, 856, 858, 861, 863, 865, 867, 868, 869, 870, 872, 874, 876, 877, 878, 879, 885, 888, 891, 894, 895, 896, 897, 899, 901, 903, 904, 907, 908, 909, 910, 912, 913, 914, 916, 917, 919, 920, 921, 923, 928, 929, 930, 934, 936, 939, 940, 942, 943, 946, 947, 950, 955, 958, 961, 964, 966, 967, 970, 971, 973, 976, 977, 979, 984, 988, 989, 993, 995, 996, 998, 1000};
		BFS f = new BFS();
		System.out.println(f.searchInsert(A, 104));
	}
	public int searchInsert(int[] A, int B) {
		return BFSA(A,0,A.length-1,B);
    }
	public int BFSA(int []A,int start, int end, int B) {
		if(start>=end && (start < A.length-1 || A.length-1 == 0)) {
			return start;
		}
		if(start==A.length-1) {
			return start+1;
		}
		int mid = (start + end) /2;
		if(A[mid] == B) {
			return mid;
		}
		if(B<A[mid]) {
			return BFSA(A,start,mid,B);
		} else {
			return BFSA(A,mid+1,end,B);
		}
	}
}