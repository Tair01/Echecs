package piece;

import com.mypackage.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bishop extends Piece {
    public Bishop(Color color, Coordinates coordinates){
        super(color, coordinates);
    }

    protected Set<CoordinatesShift> getPieceMoves(){
        Set<CoordinatesShift> result = new HashSet<>();

        //bottom-left to top-right
        for(int i = -7 ;i <= 7; i++){
            if(i == 0) continue;


            result.add(new CoordinatesShift(i, i));
        }

        //top-left to bottom-right
        for(int i = -7 ;i <= 7; i++){
            if(i == 0) continue;


            result.add(new CoordinatesShift(i, -i));
        }

        return result;
    }

    @Override
    protected boolean isSquareAvailableForMove(Coordinates coordinates, Board board) {
        boolean result =  super.isSquareAvailableForMove(coordinates, board);

        if(result){
            List<Coordinates> coordinatesBetween = BoardUtils.getDiagonalCoordinatesBetween(this.coordinates, coordinates);

            for(Coordinates c: coordinatesBetween){
                if(!board.isSquareEmpty(c)){
                    return false;
                }
            }
        }

        return true;
    }

}
