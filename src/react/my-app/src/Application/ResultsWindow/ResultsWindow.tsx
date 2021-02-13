import React from 'react'
import './ResultsWindow.css'
import { CreditsWindow } from './CreditsWindow/CreditsWindow'
import { AvailableWindow } from './AvailableWindow/AvailableWindow';

interface ResultsWindowProps {
    renderId: string
}

export class ResultsWindow extends React.Component<ResultsWindowProps> {

    render(): JSX.Element {
        switch (this.props.renderId) {
            case ('credits'):
                return (
                    <div className="resultsWindowBox">
                        <CreditsWindow />
                    </div>
                );
            case ('available'):
                return (
                    <div className="resultsWindowBox">
                        <AvailableWindow />
                    </div>
                );
            default:
                return (
                    <div className="resultsWindowBox">
                        {this.props.renderId}
                    </div>
                );
        }
    }
}