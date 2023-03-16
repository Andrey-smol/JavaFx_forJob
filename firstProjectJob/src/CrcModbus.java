public class CrcModbus {

    public static Integer[] calculationCRC(Integer[] buf, int len){
        int crc = 0xFFFF, i = 0;
        while(len-- > 0){
            crc ^= buf[i++];
            for(int j = 0; j < 8; j++){
                if((crc & 1) > 0){
                    crc = (crc >> 1) ^0xA001;
                }
                else
                    crc = crc >> 1;
            }
        }
        crc = crc & 0xFFFF;
        Integer[] res = new Integer[2];
        res[0] = (crc & 0xFF);
        res[1] = ((crc >> 8) & 0xFF);
        return res;
    }
}
