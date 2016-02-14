package joel.duet.musica;

/**
 *
 * Created by joel on 22/01/16 at 22:22 at 22:23.
 */
final class Default {

    // TODO : make ticks_per_second depend on tempo
    public static final int ticks_per_second = 32;

    public static final int min_tracks_displayed = 5;
    public static final float top_margin = 0.05f;
    public static final float bottom_margin = 0.05f;

    public static final int max_midi_note = 136;
    // TODO : find something better for iniial height
    public static final float initial_pattern_height = -2500; //somewhat around A440

    public static final int default_loudness = 5; // from 1(ppp) to 8(fff)

    public static final String empty_project = "{\"Orchestra\":[],\"FX\":[],\"idTrackSelected\":0,\"idPatternSelected\":0,\"tracks\":[],\"Matrix\":\"FF\"}";
    public static final String score_events_absoluteFilePath = "/storage/sdcard0/unisonMelody.txt";

    public static final int[] resolutions = {128,64,32,16,8,4,2,1};
    public static final int[] grays = {-16777216, -16711423, -16645630, -16579837, -16514044, -16448251, -16382458, -16316665, -16250872, -16185079, -16119286, -16053493, -15987700, -15921907, -15856114, -15790321, -15724528, -15658735, -15592942, -15527149, -15461356, -15395563, -15329770, -15263977, -15198184, -15132391, -15066598, -15000805, -14935012, -14869219, -14803426, -14737633, -14671840, -14606047, -14540254, -14474461, -14408668, -14342875, -14277082, -14211289, -14145496, -14079703, -14013910, -13948117, -13882324, -13816531, -13750738, -13684945, -13619152, -13553359, -13487566, -13421773, -13355980, -13290187, -13224394, -13158601, -13092808, -13027015, -12961222, -12895429, -12829636, -12763843, -12698050, -12632257, -12566464, -12500671, -12434878, -12369085, -12303292, -12237499, -12171706, -12105913, -12040120, -11974327, -11908534, -11842741, -11776948, -11711155, -11645362, -11579569, -11513776, -11447983, -11382190, -11316397, -11250604, -11184811, -11119018, -11053225, -10987432, -10921639, -10855846, -10790053, -10724260, -10658467, -10592674, -10526881, -10461088, -10395295, -10329502, -10263709, -10197916, -10132123, -10066330, -10000537, -9934744, -9868951, -9803158, -9737365, -9671572, -9605779, -9539986, -9474193, -9408400, -9342607, -9276814, -9211021, -9145228, -9079435, -9013642, -8947849, -8882056, -8816263, -8750470, -8684677, -8618884, -8553091, -8487298, -8421505, -8355712, -8289919, -8224126, -8158333, -8092540, -8026747, -7960954, -7895161, -7829368, -7763575, -7697782, -7631989, -7566196, -7500403, -7434610, -7368817, -7303024, -7237231, -7171438, -7105645, -7039852, -6974059, -6908266, -6842473, -6776680, -6710887, -6645094, -6579301, -6513508, -6447715, -6381922, -6316129, -6250336, -6184543, -6118750, -6052957, -5987164, -5921371, -5855578, -5789785, -5723992, -5658199, -5592406, -5526613, -5460820, -5395027, -5329234, -5263441, -5197648, -5131855, -5066062, -5000269, -4934476, -4868683, -4802890, -4737097, -4671304, -4605511, -4539718, -4473925, -4408132, -4342339, -4276546, -4210753, -4144960, -4079167, -4013374, -3947581, -3881788, -3815995, -3750202, -3684409, -3618616, -3552823, -3487030, -3421237, -3355444, -3289651, -3223858, -3158065, -3092272, -3026479, -2960686, -2894893, -2829100, -2763307, -2697514, -2631721, -2565928, -2500135, -2434342, -2368549, -2302756, -2236963, -2171170, -2105377, -2039584, -1973791, -1907998, -1842205, -1776412, -1710619, -1644826, -1579033, -1513240, -1447447, -1381654, -1315861, -1250068, -1184275, -1118482, -1052689, -986896, -921103, -855310, -789517, -723724, -657931, -592138, -526345, -460552, -394759, -328966, -263173, -197380, -131587, -65794, -1};

    public static final Integer[] resolution_icons = new Integer[]{R.drawable.ic_1st_note,R.drawable.ic_2nd_note,R.drawable.ic_4th_note,R.drawable.ic_8th_note,R.drawable.ic_16th_note,R.drawable.ic_32th_note,R.drawable.ic_64th_note,R.drawable.ic_128th_note};
    public static final Integer[] edition_icons = new Integer[]{R.drawable.ic_compose,R.drawable.ic_copy,R.drawable.ic_move,R.drawable.ic_join,R.drawable.ic_split,R.drawable.ic_quantize};
    public static final Integer[] loudness_icons = new Integer[]{R.drawable.ic_fortississimo,R.drawable.ic_fortissimo,R.drawable.ic_forte,R.drawable.ic_mezzo_forte,R.drawable.ic_mezzo_piano,R.drawable.ic_piano,R.drawable.ic_pianissimo,R.drawable.ic_pianississimo};
}
