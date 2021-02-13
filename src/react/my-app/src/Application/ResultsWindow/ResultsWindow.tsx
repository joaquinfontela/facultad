import React from 'react'
import './ResultsWindow.css'
import { CreditsWindow } from './CreditsWindow/CreditsWindow'

interface ResultsWindowProps {
    renderId: string
}

export class ResultsWindow extends React.Component<ResultsWindowProps> {

    render(): JSX.Element {
        if (this.props.renderId === 'credits') {
            return (
                <div className="resultsWindowBox">
                    <CreditsWindow />
                </div>
            );
        }

        return (
            <div className="resultsWindowBox">
                {this.props.renderId}
            </div>
        );
    }
}