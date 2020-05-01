import java.io.FileWriter;  
import java.io.IOException;
/**
 * Beschreiben Sie hier die Klasse Messreihe.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Messreihe
{
    private static Palindrom palindromRekursiv = new PalindromRekursiv();
    private static Palindrom palindromIterativ = new PalindromIterativ();
    public static String[][] palindromicStrings  = {  { "a", "u", "o", "y" },
                                        { "uu", "yy", "vv", "ii" },
                                        { "aba", "ziz", "opo", "tit" },
                                        { "cggc", "hqqh", "abba", "otto" },
                                        { "zuiuz", "abcba", "uzizu", "qrtrq" },
                                        { "ammmma", "iuttui", "praarp", "vuiiuv" },
                                        { "abitiba", "hobtboh", "schahcs", "beilieb" },
                                        { "zoittioz", "qwrttrwq", "schaahcs", "baraarab" },
                                        { "byqiaiqyb", "ftuoaoutf", "xdhcachdx", "wwoeaeoww" },
                                        { "hffrllrffh", "bupyppypub", "weejssjeew", "mfxillixfm" },
                                        { "cqjqkakqjqc", "vghbyaybhgv", "kgvjyayjvgk", "csdrnanrdsc" },
                                        { "sztgxeexgtzs", "moxmpggpmxom", "uffgzbbzgffu", "vdvrvwwvrvdv" },
                                        { "lvujruaurjuvl", "dobqpzazpqbod", "hhioyhahyoihh", "tvpehfafhepvt" },
                                        { "ahofbattabfoha", "dqwljiddijlwqd", "mpikhyggyhkipm", "tbhiirffriihbt" },
                                        { "kmdcujzazjucdmk", "karwovyayvowrak", "mwjylnaaanlyjwm", "dnwsngiaignswnd" },
                                        { "mdlczirmmrizcldm", "yrubnirttrinbury", "shriommhhmmoirhs", "sblwesrllrsewlbs" },
                                        { "pahrrfptatpfrrhap", "ynsfjonsasnojfsny", "xsnvmzwnanwzmvnsx", "andefjsqaqsjfedna" },
                                        { "vgdswmimttmimwsdgv", "whtshfmbyybmfhsthw", "ftayqefniinfeqyatf", "tmdpdaqittiqadpdmt" },
                                        { "ofnmblsluaulslbmnfo", "gugevzobuaubozvegug", "hfofngglnanlggnfofh", "vvilzyokvavkoyzlivv" },
                                        { "lefoefzgjkkjgzfeofel", "nwyirdpxsccsxpdriywn", "nbptrzqsiqqisqzrtpbn", "vjgaorzcgqqgczroagjv" },
                                        { "prbczvqqfrarfqqvzcbrp", "jjaipfgpbkakbpgfpiajj", "cdqpocqnfvavfnqcopqdc", "ksqpdwwmfhahfmwwdpqsk" },
                                        { "lpffdskvmkddkmvksdffpl", "fgprrswwpgddgpwwsrrpgf", "aphmyzhfksbbskfhzymhpa", "wyrxecvomlbblmovcexryw" },
                                        { "dxrrsxgnmprarpmngxsrrxd", "qolkvtprhflalfhrptvkloq", "fhgtahaiqizaziqiahatghf", "rgjgokyrbtrartbrykogjgr" },
                                        { "ulpjiljhmowzzwomhjlijplu", "xooftekqbcitticbqketfoox", "hvhcislzhcijjichzlsichvh", "kspzmteldhwyywhdletmzpsk" },
                                        { "czfhwsouexzqaqzxeuoswhfzc", "wugeczbtlfbgagbfltbzceguw", "pygzvqwliofmamfoilwqvzgyp", 
                                            "wukvnuoaobdxaxdboaounvkuw" },
                                        { "kjfeeivoewewbbweweovieefjk", "htcfaubpvhqwqqwqhvpbuafcth", "pynjivvebusneensubevvijnyp", 
                                            "yfpdaphrkuudffduukrhpadpfy" },
                                        { "zndhjtjhpwyipapiywphjtjhdnz", "woqzuazemvcccacccvmezauzqow", "wynopkztyelhrarhleytzkponyw", 
                                            "ijounvezkwyldadlywkzevnuoji" },
                                        { "hfxgmpuacpablxxlbapcaupmgxfh", "fieynwtnhsrcyuuycrshntwnyeif", "lhmquaxcfpymbrrbmypfcxauqmhl", 
                                            "sjwzrgcqyfzxtxxtxzfyqcgrzwjs" },
                                        { "jdofdorecicdbuaubdcicerodfodj", "mlhyopyhtemgsyaysgmethypoyhlm", "paanalojxtieyaaayeitxjolanaap", 
                                            "oqztnzfmmkkmwwawwmkkmmfzntzqo" },
                                        { "zodbavxlnzklhjyyjhlkznlxvabdoz", "cxxsxamnrftxooyyooxtfrnmaxsxxc", "lkrofrcjmavesvaavsevamjcrforkl", 
                                            "bkdgvfnpbwhlidaadilhwbpnfvgdkb" },
                                        { "kfdbfvtzdjompxdadxpmojdztvfbdfk", "bjatgfhknejhapiaipahjenkhfgtajb", "ubcqancjmvclmmyaymmlcvmjcnaqcbu", 
                                            "ncmychkcvacbsvkakvsbcavckhcymcn" },
                                        { "fosaxfszjgwrkplvvlpkrwgjzsfxasof", "yzztwvwdkuzpmfsoosfmpzukdwvwtzzy", "bbvownkkodvlgyoxxoyglvdokknwovbb", 
                                            "dutoxpjkdewnlctrrtclnwedkjpxotud" },
                                        { "niiuzcpsjzbxgnnxaxnngxbzjspczuiin", "gnterqjgzdxhtqnkaknqthxdzgjqretng", "rriwxlztfwkbpzdmamdzpbkwftzlxwirr", 
                                            "ozuqkrtlvmqeskncacnkseqmvltrkquzo" },
                                        { "vmpnhbpenlvwguhweewhugwvlnepbhnpmv", "ipifduyhzzkweyzhxxhzyewkzzhyudfipi", 
                                            "acwgxgefnialjvqiwwiqvjlainfegxgwca", "ogntowmzmlatwneemmeenwtalmzmwotngo" }        

                                    };
    public static String[][] nonPalindromicStrings = {{ "ua", "yb", "78", "tl" },
                                        { "lat", "eap", "xam", "oah" },
                                        { "hapa", "lxun", "igtz", "skuu" },
                                        { "mpaoe", "ykamg", "anacb", "zcani" },
                                        { "avvhfu", "itxsrh", "iebzck", "zxcyka" },
                                        { "gbeaxfm", "rkcazoy", "xxwaoyh", "iroabaz" },
                                        { "rvuigcmw", "xglnkidh", "vrktyrag", "evxuindr" },
                                        { "pekkanddx", "hdgkakvqd", "tihfajqks", "ypyhagmgw" },
                                        { "zzvgqjhamf", "lucowseesa", "karsyztlwr", "dxwrmrymhg" },
                                        { "dimwuadmbxc", "jvslxafppep", "vdojpafqjpq", "xsrfyacquxr" },
                                        { "walezieqkhtv", "nhiqtayyigeh", "uvsuvzsttooa", "ujzjgavfbbrv" },
                                        { "vmelizancbpei", "cdqwgdasakbwa", "ohzaaxakcdoey", "gpxydcaattfrr" },
                                        { "zepkbsxspwmnuj", "imtpaghipbgbzn", "tiqwzrrtgcotmd", "lorzmppnklncjp" },
                                        { "qfzjzdpaohgqbfl", "xedicnladjcxvhz", "ggxsgbravaambxs", "bvrtjzfachtyirj" },
                                        { "wdszpseqqvbaaant", "ersziigzysugtldo", "qbraknfmqrunofrn", "sejtxmpldyjsxtui" },
                                        { "kotgycpkablbxtomj", "bizkrtbracjiblcmw", "ncaucopqakpoprwjb", "jcilxyfuapzetcaly" },
                                        { "iucojzeggtyrdgsqvw", "gbfvzrnaosqhcroevp", "iqypgxpyvevtajvvxi", "mqydjmglttccwayews" },
                                        { "mjyvklsguaytrzrdrvu", "gnlxgxlnjazpcronscv", "urnvuviapamjatlqdrv", "pfbfntbaoaoidylhdbu" },
                                        { "zlzvzcovvxvbxwblcunj", "obyboaomkvxpoiopamtz", "yvdibokovxyqftzxxuif", "uhpuzkujpsavwpeaowtx" },
                                        { "vtmzijowzqakuambjgwgk", "pnpuzrweffacwkdlibnbf", "efpjxohgyuahqvdbhcitl", "ozkkouueznabiboxmyixl" },
                                        { "vnudtxfledkkrxriammpro", "cqxehyppacbvjxmumiaduz", "pcddfymhuxsesbznvxxfnu", "cnnsailkqrgavorjtwnilk" },
                                        { "gpdwkupjhfwavqhakzlcpcu", "nvgmttcmbfuahrsggssjkcb", "uueiqydfqzzalmlaldpyfnc", "wggwyaxsgbtapbgxvgilwkw" },
                                        { "rppvibrsmudpqzuryrbgvrct", "ttihsvmttnvzyqwkagrbpugt", "rlfwibsbtfxzstloswzwpdtq", 
                                            "iyjgsncupnuwebvhcpvwpzay" },
                                        { "xzjcmcqlcmbgahpmwvxoinwim", "okhplztifafraokgrjnnsanro", "bttpqbsbwreaaafzimnqwyebe", 
                                            "nyjhkneqaoopabxfqgiksbyir" },
                                        { "ntsxfffyxxdcqkxvrnweghpwwf", "dnoeomqlkjzjwhhnseuwcdfgwy", "xipinjajesfxupfndvcqkimxvp", 
                                            "rjtqnysdsbtyiazrmagwquyzjr" },
                                        { "owudfcnvexhpiaknfpssykkgtom", "flwvssofshnfzaypnepaawrdpek", "ctzsdgxmihoudatpfxhampnuhzi", 
                                            "mdqilnlougiwhagnhoskdyqiviq" },
                                        { "pbtprpkqqwnaluokaawpnlcetgbq", "askyfeslwnraohqyekrnknrsnere", "lywulrrfljizyqjxcvaeilmxngkq", 
                                            "vbusxnqrzwcbqzrgilfgkzwlsido" },
                                        { "bfkuiivwradrdgaggxuqavwzcxvxc", "szexqobcinxtskabchoiistqqwbgw", "eqndijffpfulsqafkjesoltfcqslb", 
                                            "kkuaoglyyfrusoarghrbdytzoxmez" },
                                        { "tdlcxwxrfjljwhrqdctxeeyhkonxul", "nrrftofpbdmfaiktaukfdwoozbgwwb", "exhvksibicbitfocnifoqtnlaqshyx", 
                                            "rqjamsenkvvqyikltqccnjuypbyffo" },
                                        { "dgzomooiysaddwpaleptvsbasxoqgqp", "mwzjoralvgkfbyjafnhekwxbkfssvoj", "htpchsschvhzkihakrmlbxpmsnqyyzr", 
                                            "upbcgnedkypfcmkadckhsnfuntngfzq" },
                                        { "zbpiiiwphydjpvwvldjgetogzoaljnru", "zcawimvdabsomafuafxyqngvhizomjyb", "iexwmjgmbehsfpqvzuehxbmrzhjalvfm", 
                                            "uzrupjrsklnbhdknmbkhnvlggoqxapys" },
                                        { "uadtymvvbxuwabcjacumnumisducpxfqm", "nimzudsnfvvhluhxakmxhueguwsfcebxm", "dndrmmsexisgdtzeaabqugxouvyudfagw", 
                                            "ozfmnsmkyycpzfzoajwiygyolkxazpvtq" },
                                        { "eiqjvojtzzxvfgxxwbqhendkjrikejeyzj", "jsiwzhffztqksdakxrhqjbrrdbnwfbbaru", 
                                            "bluthbcvvewfvctapvnxvwdnmoeptxwwdt", "pkjeufiixsdskghixfjppajwxmtwktqrbk" },

                                      };
    public static void main(String[] args) {
       process(palindromicStrings, "rekursiv_true.txt", "iterativ_true.txt");
       process(nonPalindromicStrings, "rekursiv_false.txt", "iterativ_false.txt");
    }
    
    private static void process(String[][] testList, String rekursivNameFile, String iterativNameFile) {
        StringBuilder it = new StringBuilder();
        StringBuilder rk = new StringBuilder();
        long beginn;
        long ende;
        long rekursivZeit = 0L;
        long iterativZeit = 0L;
        for (int j = 0; j < testList.length; j++) {
            rekursivZeit = 0L;
            iterativZeit = 0L;
            for (int k = 0; k < testList[j].length; k++) {
                beginn = System.nanoTime();
                palindromRekursiv.istPalindrom(testList[j][k]);
                rekursivZeit += System.nanoTime() - beginn;
                beginn = System.nanoTime();
                palindromIterativ.istPalindrom(testList[j][k]);
                iterativZeit += System.nanoTime() - beginn;
            }
            it.append(iterativZeit/4 + ", ");
            rk.append(rekursivZeit/4 + ", ");
        }
        String itString = it.toString();
        itString = itString.substring(0, itString.length() - 2);
        String rkString = rk.toString();
        rkString = rkString.substring(0, rkString.length() - 2);
        
        try {
          FileWriter rekursivWriter = new FileWriter(rekursivNameFile);
          rekursivWriter.write(rkString);
          FileWriter iterativWriter = new FileWriter(iterativNameFile);
          iterativWriter.write(itString);
          rekursivWriter.close();
          iterativWriter.close();
          System.out.println("Erfolgreich gemessen, siehe " + rekursivNameFile + " und " + iterativNameFile);
        } catch (IOException e) {
          System.out.println("Fehler!");
          e.printStackTrace();
        }
    }
}
